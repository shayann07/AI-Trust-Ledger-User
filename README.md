# AI Trust Ledger User

![Platform](https://img.shields.io/badge/Platform-Android-green.svg)
![Language](https://img.shields.io/badge/Language-Kotlin_2.0.21-blue.svg)
![License](https://img.shields.io/badge/License-MIT-orange.svg)

## Overview
**AI Trust Ledger User** is the native Android client application for the AI Trust Ledger FinTech and ROI platform. Built with a modern Android tech stack, it provides users with a seamless interface to manage their accounts, track their deposits and withdrawals using USDT-BEP20, purchase investment plans with daily returns, monitor their multi-tier MLM earnings, and receive real-time FCM push notifications.

## Key Features
- **User Onboarding & Authentication:** Secure sign-up, login, and session management.
- **Deposit & Withdrawal Tracking:** Manage transactions securely with USDT-BEP20 integration.
- **Investment Plans:** Purchase and monitor investment plans offering automated daily ROI.
- **Multi-Tier MLM Earnings:** Monitor team structures, downlines, and referral bonuses across multiple tiers.
- **Push Alerts:** Real-time updates and notifications powered by Firebase Cloud Messaging (FCM v1).

## System Architecture
The application is built using a modern Android development approach to ensure scalability, maintainability, and responsiveness:
- **Architecture Pattern:** Single-Activity MVVM (Model-View-ViewModel) architecture.
- **UI & Layouts:** ViewBinding for type-safe view references.
- **Asynchrony & Concurrency:** Kotlin Coroutines for lightweight, efficient background task management.
- **Backend Infrastructure:** Cloud Firestore for real-time NoSQL database capabilities and Firebase Auth for secure identity management.
- **Local Storage:** Room database for robust offline caching and data persistence.

## Setup Guide

### Prerequisites
- Android Studio Ladybug or later.
- JDK 17 or later.
- Android SDK 35.

### Configuration
1. **Clone the repository:**
   ```bash
   git clone https://github.com/shayann07/AI-Trust-Ledger-User.git
   ```
2. **Setup Firebase Configuration:**
   - Copy the provided example template:
     ```bash
     cp app/google-services.json.example app/google-services.json
     ```
   - Update `app/google-services.json` with your Firebase project credentials.
3. **Setup Local SDK Path (Optional):**
   - Copy the local properties template:
     ```bash
     cp local.properties.example local.properties
     ```
   - Update the `sdk.dir` property in `local.properties` to point to your Android SDK installation.
4. **Build and Run:**
   - Sync the project with Gradle files.
   - Build and run the app on an emulator or physical device.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
