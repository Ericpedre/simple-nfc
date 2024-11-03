package com.mycompany.plugins.example;

import android.content.Context;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.util.Log;
import android.nfc.tech.Ndef;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@CapacitorPlugin(name = "Example")
public class ExamplePlugin extends Plugin {

  @PluginMethod
  public void echo(PluginCall call) {
    String value = call.getString("value");

    JSObject ret = new JSObject();
    ret.put("value", value);
    Context context = getContext();

    NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(context);

    nfcAdapter.enableReaderMode(getActivity(), new NfcAdapter.ReaderCallback() {

      String payload = "";

      @Override
      public void onTagDiscovered(Tag tag) {
        Log.d("NFC", "Tag discovered");

        Ndef ndef = Ndef.get(tag);
        if (ndef != null) {
          try {
            ndef.connect();
            NdefMessage ndefMessage = ndef.getNdefMessage();
            if (ndefMessage != null) {
              for (NdefRecord ndefRecord : ndefMessage.getRecords()) {
                if (ndefRecord.getTnf() == NdefRecord.TNF_WELL_KNOWN &&
                  java.util.Arrays.equals(ndefRecord.getType(), NdefRecord.RTD_TEXT)) {
                  payload = new String(ndefRecord.getPayload(), StandardCharsets.UTF_8);
                  Log.d("NFC", "Ndef Record: " + payload);
                  ret.put("value", payload);
                  call.resolve(ret);
                  return;
                }
              }
            }
            ndef.close();
          } catch (IOException | FormatException e) {
            Log.e("NFC", "Error communicating with NFC tag", e);
            ret.put("value", "Error communicating with NFC tag");
            call.resolve(ret);
          }
        }
      }
    }, NfcAdapter.FLAG_READER_NFC_A, null);
  }
}
