# SpaceXApp (Kotlin Multiplatform)

This repository contains a Kotlin Multiplatform Mobile (KMM) sample app named SpaceXApp. It is organized into:

- androidApp/ — Android-specific app module
- iosApp/ — iOS-specific app module
- sharedLogic/ — shared Kotlin code (business logic, networking)
- sharedUI/ — shared UI code

The project follows the Kotlin Multiplatform approach and integrates Ktor for networking and SQLDelight for persistence, based on the official guide: https://kotlinlang.org/docs/multiplatform/multiplatform-ktor-sqldelight.html

What was done here
- Initialized a Git repository at the project root
- Added this README.md describing the project
- Added a .gitignore tuned for Kotlin/Android/Gradle and committed the project files

How to push to GitHub
1. Create a new repository on GitHub (via the website or API).
2. Add the remote and push:

   git remote add origin git@github.com:USERNAME/REPO.git
   git branch -M main
   git push -u origin main

Replace USERNAME/REPO with your GitHub repo path.

If you want, I can create the GitHub repository for you (will need a GitHub token with repo scope). EOF

cat > .gitignore <<'EOF'
# Gradle
.gradle/
build/
**/build/

# IntelliJ / Android Studio
.idea/
*.iml
*.iws

# Local properties
local.properties

# Kotlin/Native
.cocoapods/

# Xcode
xcuserdata/
*.xcworkspace
*.xcuserstate

# Misc
.DS_Store

