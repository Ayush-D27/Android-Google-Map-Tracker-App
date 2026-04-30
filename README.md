# Android Google Map Tracker App

## Overview

This project is a simple Android application built using Android Studio that allows users to get directions between two locations using Google Maps. It demonstrates how to use intents and URLs to integrate navigation functionality.

---

## Features

* Enter **source (from)** and **destination (to)** locations
* Opens directions directly in Google Maps
* Uses intent-based navigation (no API key required)
* Validates user input before processing
* Redirects to Play Store if Google Maps is not installed

---

## Tech Stack

* Language: Java
* IDE: Android Studio
* Components Used:

  * `Intent`
  * `Uri`
  * `EditText`
  * `Button`
  * `Toast`

---

## How It Works

1. User enters **starting location** and **destination**.
2. App validates that both fields are not empty.
3. Constructs a Google Maps URL:

   ```
   https://www.google.com/maps/dir/<from>/<to>
   ```
4. Converts URL into `Uri`.
5. Launches Google Maps using `Intent.ACTION_VIEW`.
6. If Google Maps is not installed, redirects to Play Store.

---

## Setup Instructions

1. Open project in Android Studio
2. Run the app on emulator or physical device
3. Enter source and destination locations
4. Click **Get Direction** to open navigation

---

## Code Highlights

* `Uri.parse()` creates navigation link
* `Intent.ACTION_VIEW` opens Google Maps
* `intent.setPackage()` ensures Maps app is used
* Exception handling redirects to Play Store if app is missing

---

## Learning Outcomes

* Working with Android Intents
* URL-based navigation integration
* Handling user input and validation
* External app interaction using package names
