# Simple NFC

Simple NFC is a capacitor library created to read plain text from an nfc tag.
In this version it only has this functionality and it only works for android devices but little by little we will be adding other functions.
It is a very simple code so you can modify it to your liking to create the functions you need in your application.
Any contribution with the code will be welcome.

## Install

```bash
npm install simple-nfc
npx cap sync
```

## API

<docgen-index>

* [`readNfc(...)`](#readnfc)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### readNfc(...)

```typescript
readNfc(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------

</docgen-api>

# Usage

## In an Angular aplication: 


You must import the plugin in your **`page.ts`**

```typescript
import { Example } from 'simple-nfc';
```

Then you can create this function to read the tag:

```typescript
public resp: string = '';

async readNfcPlugin() {
    try {
        // Any string can go in the value parameter
        const result = await Example.readNfc({ value: 'Hello, World!' });
        console.log("NFC Content: " + result.value);
        this.resp = result.value;
    } catch (error) {
        console.error('Error using Example plugin', error);
    }
  }
```

To display it on the screen:

```html
<p>Response: {{ resp }}</p>
```

### Run 

To run the project with these changes you just need to run:

```bash
ionic cap sync android
ionic cap open android
```
And generate the apk or run your project in android studio




