@echo off
echo ** Signature du fichier JAR **
jarsigner -keystore store/group12store -storepass group12 -keypass group12 -signedjar ./applet/Applet.jar ./dist/group12.jar group12
echo ** Signature OK ! **
pause