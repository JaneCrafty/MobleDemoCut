#!/bin/bash

# Define the directory and file patterns
ARTIFACTS_DIR="./artifacts"
ZIP_FILE_PATTERN="marketly_assistant-*.zip"
DEST_DIR="android/app/build/outputs/apk/marketly_assistant/release"

# Check if any matching ZIP file exists in the artifacts directory
ZIP_FILE=$(find "$ARTIFACTS_DIR" -type f -name "$ZIP_FILE_PATTERN")

if [[ -z "$ZIP_FILE" ]]; then
  echo "Error: No matching ZIP file found in $ARTIFACTS_DIR"
  exit 1
fi

# Extract the ZIP file
echo "Extracting $ZIP_FILE..."
unzip "$ZIP_FILE" -d "$ARTIFACTS_DIR"

# Find the extracted APK file
APK_FILE=$(find "$ARTIFACTS_DIR" -type f -path "*/release/app-marketlyAssistant-release.apk")

if [[ -z "$APK_FILE" ]]; then
  echo "Error: APK file not found in the extracted contents"
  exit 1
fi

# Create the destination directory if it does not exist
mkdir -p "$DEST_DIR"

# Move the APK file to the destination directory
echo "Moving APK file to $DEST_DIR..."
cp "$APK_FILE" "$DEST_DIR/"

echo "APK file successfully copied to $DEST_DIR"
