# QR Code Generator Module

This module provides utilities for generating and reading QR codes using the ZXing (Zebra Crossing) library.

## Module Overview

The `proj_qrcode` module offers:
- QR code generation from text/URLs
- QR code reading/decoding
- Customizable QR code dimensions
- Support for multiple image formats

## Available Utilities

| Class | Description |
|-------|-------------|
| `GenerateQRCodeMain` | Generate QR codes from text or URLs |
| `QRCodeReaderMain` | Read and decode existing QR code images |

## Prerequisites

- **Java 17** or higher
- **Maven 3.6+**

## Dependencies

| Dependency | Version | Purpose |
|------------|---------|---------|
| ZXing Core | 3.5.0 | Core barcode processing library |
| ZXing JavaSE | 3.5.0 | Java SE specific utilities |

## Building the Module

```bash
# From the root project directory
mvn clean install -pl proj_qrcode

# Or from the proj_qrcode directory
cd proj_qrcode
mvn clean install
```

## Usage Examples

### Generate QR Code

```java
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

// Create a BitMatrix for the QR Code
String content = "https://example.com";
int width = 500;
int height = 500;

BitMatrix bitMatrix = new MultiFormatWriter()
    .encode(content, BarcodeFormat.QR_CODE, width, height);

// Save to file
MatrixToImageWriter.writeToPath(bitMatrix, "PNG", Paths.get("qrcode.png"));
```

### Read QR Code

```java
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;

BufferedImage image = ImageIO.read(new File("qrcode.png"));
LuminanceSource source = new BufferedImageLuminanceSource(image);
BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

Result result = new MultiFormatReader().decode(bitmap);
System.out.println("Content: " + result.getText());
```

## Running Examples

### Generate a QR Code

```bash
cd proj_qrcode
mvn compile exec:java -Dexec.mainClass="com.proj.qrcodegenerator.GenerateQRCodeMain"
```

### Read a QR Code

```bash
mvn compile exec:java -Dexec.mainClass="com.proj.qrcodereader.QRCodeReaderMain"
```

**Note:** Update file paths in the source code before running.

## Supported Formats

### Barcode Formats

ZXing supports multiple barcode formats:

| Format | Type | Common Use |
|--------|------|------------|
| QR_CODE | 2D | General purpose, URLs, text |
| DATA_MATRIX | 2D | Industrial, small items |
| AZTEC | 2D | Transport tickets |
| PDF_417 | 2D | ID cards, boarding passes |
| CODE_128 | 1D | Shipping, inventory |
| EAN_13 | 1D | Retail products |
| UPC_A | 1D | North American retail |

### Image Formats

| Format | Extension | Notes |
|--------|-----------|-------|
| PNG | .png | Recommended, lossless |
| JPEG | .jpg | Lossy, smaller file size |
| GIF | .gif | Limited colors |
| BMP | .bmp | Uncompressed |

## Configuration Options

### QR Code Generation

```java
// Set hints for better quality
Map<EncodeHintType, Object> hints = new HashMap<>();
hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
hints.put(EncodeHintType.MARGIN, 2);

BitMatrix bitMatrix = new MultiFormatWriter()
    .encode(content, BarcodeFormat.QR_CODE, width, height, hints);
```

### Error Correction Levels

| Level | Recovery Capacity | Use Case |
|-------|-------------------|----------|
| L | ~7% | Maximum data capacity |
| M | ~15% | Default, balanced |
| Q | ~25% | Better recovery |
| H | ~30% | Highest recovery, logos |

## QR Code Content Types

QR codes can encode various types of data:

| Type | Format Example |
|------|----------------|
| URL | `https://example.com` |
| Email | `mailto:test@example.com` |
| Phone | `tel:+1234567890` |
| SMS | `smsto:+1234567890:Message` |
| WiFi | `WIFI:T:WPA;S:NetworkName;P:password;;` |
| vCard | `BEGIN:VCARD...END:VCARD` |
| Plain Text | Any text string |

## Best Practices

1. **Size Matters** - Use appropriate dimensions for scanning distance
2. **Contrast** - Black on white provides best readability
3. **Error Correction** - Higher level for logos or physical wear
4. **Testing** - Always test generated codes with multiple readers
5. **Quiet Zone** - Maintain white space around QR code

## Troubleshooting

### Common Issues

| Issue | Solution |
|-------|----------|
| QR code not scanning | Increase size or error correction level |
| Blurry image | Use PNG format, increase dimensions |
| Content too long | Use URL shortener or compression |
| Special characters | Ensure UTF-8 encoding |

## Output Location

Generated QR codes are saved to:
```
proj_qrcode/src/main/resources/qrcodes/
```

## Related Modules

- `proj_pdf` - Embed QR codes in PDF documents
- `core-java` - File I/O operations

