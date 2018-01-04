# NFC Reader mode bug example

This repository contains the code for reproducing a bug found in `reader mode`.

## Motivation

In 2014 while developing the Fidesmo Android app we found a bug in the NFC stack
when using the `reader mode`. This repository was created and shared with Google
in their issue tracker. The bug allows Android apps to re-discover devices that
are close to the NFC antenna when switching Activities. This behaviour is not in
accordance to specification.

## Usage

Run the app on an Android device and interact with a NFC device.

## Development

This project is developed using Android Studio.
