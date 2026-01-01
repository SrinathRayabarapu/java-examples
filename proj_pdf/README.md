# PDF Utilities Module

This module provides utility classes for PDF manipulation using Apache PDFBox library.

## Module Overview

The `proj_pdf` module offers common PDF operations including:
- Merging multiple PDFs into one
- Creating PDFs from images
- Rotating PDF pages
- Encrypting/Decrypting PDF files
- Shrinking/Compressing PDFs

## Available Utilities

| Class | Description |
|-------|-------------|
| `MergePdf` | Merge multiple PDF files into a single document |
| `CreatePDFFromImage` | Convert images to PDF format |
| `RotatePDF` | Rotate pages within a PDF document |
| `DecryptPdf` | Remove password protection from PDFs |
| `ShrinkPDF` | Compress PDF to reduce file size |

## Prerequisites

- **Java 17** or higher
- **Maven 3.6+**

## Dependencies

| Dependency | Version | Purpose |
|------------|---------|---------|
| Apache PDFBox | 2.0.22 | Core PDF manipulation library |
| Bouncy Castle Provider | 1.68 | Encryption support |
| Bouncy Castle Mail | 1.68 | Additional security features |

## Building the Module

```bash
# From the root project directory
mvn clean install -pl proj_pdf

# Or from the proj_pdf directory
cd proj_pdf
mvn clean install
```

## Usage Examples

### Merge PDFs

```java
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.io.MemoryUsageSetting;

PDFMergerUtility merger = new PDFMergerUtility();
merger.addSource(new File("doc1.pdf"));
merger.addSource(new File("doc2.pdf"));
merger.setDestinationFileName("merged.pdf");
merger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
```

### Create PDF from Image

```java
// See CreatePDFFromImage.java for implementation
```

### Rotate PDF Pages

```java
// See RotatePDF.java for implementation
```

## Running Examples

```bash
# Run the merge PDF example
mvn compile exec:java -Dexec.mainClass="com.srinath.pdf.MergePdf"

# Run create PDF from image
mvn compile exec:java -Dexec.mainClass="com.srinath.pdf.CreatePDFFromImage"

# Run rotate PDF
mvn compile exec:java -Dexec.mainClass="com.srinath.pdf.RotatePDF"
```

**Note:** Update the file paths in the source code to point to your actual PDF files before running.

## Key Features

### PDFBox Library Features Used

1. **PDFMergerUtility** - Combining multiple PDFs
2. **PDDocument** - Core PDF document handling
3. **PDPage** - Page manipulation
4. **PDImageXObject** - Image handling
5. **Encryption** - Password protection

### Memory Settings

For large PDFs, use appropriate memory settings:

```java
// Use main memory only (faster, but limited by heap)
MemoryUsageSetting.setupMainMemoryOnly()

// Use temp files for large documents
MemoryUsageSetting.setupTempFileOnly()

// Mixed mode (recommended for large files)
MemoryUsageSetting.setupMixed(100 * 1024 * 1024) // 100MB threshold
```

## Common Operations

### Opening a PDF

```java
PDDocument document = PDDocument.load(new File("input.pdf"));
try {
    // Work with document
} finally {
    document.close();
}
```

### Saving a PDF

```java
document.save("output.pdf");
```

### Password Protection

```java
// Encryption requires Bouncy Castle library
AccessPermission permissions = new AccessPermission();
StandardProtectionPolicy policy = new StandardProtectionPolicy(
    "ownerPassword", 
    "userPassword", 
    permissions
);
document.protect(policy);
```

## Best Practices

1. **Always close documents** - Use try-with-resources or finally blocks
2. **Handle memory carefully** - Use temp files for large PDFs
3. **Validate inputs** - Check file existence before processing
4. **Handle exceptions** - PDFBox throws IOExceptions

## Troubleshooting

### Common Issues

| Issue | Solution |
|-------|----------|
| OutOfMemoryError | Use temp file memory setting |
| File not found | Verify file paths are correct |
| Encrypted PDF errors | Add Bouncy Castle dependencies |
| Corrupted output | Ensure documents are closed properly |

## Related Modules

- `core-java` - File I/O operations
- `proj_qrcode` - Image generation for embedding in PDFs

