# simple-nfc

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
