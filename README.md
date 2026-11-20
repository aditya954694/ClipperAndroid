# Clipper Engine Android Port (Starter)

This is a new Android Studio Kotlin/Jetpack Compose project scaffold inspired by the public README for Clipper Engine. It is **not** a conversion of the original desktop app and does not yet implement stream recording, chat activity detection, clipping, captions, or video rendering.


## Build
1. Install Android Studio on a computer.
2. Open this folder in Android Studio.
3. Allow Gradle sync to finish (internet is required for dependencies).
4. Run on an Android device/emulator (Android 8.0/API 26+).

The app currently provides a dark dashboard UI, feature placeholders, and a button to open the existing live preview.


## Next development milestones
- Stream discovery providers and stream URLs.
- Playback and chat overlays with platform-appropriate integrations.
- Android foreground-service recording with user-visible controls and storage handling.
- Clip segment extraction (FFmpeg/mobile-compatible media pipeline).
- Speech captions and 9:16/16:9 export.

Platform integrations may be limited by Twitch/YouTube/Kick API and content rules. Do not record or repost streams without appropriate permission.
