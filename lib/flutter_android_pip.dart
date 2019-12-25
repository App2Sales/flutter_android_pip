import 'package:flutter/services.dart';

class FlutterAndroidPip {
  static const MethodChannel _channel =
      const MethodChannel('flutter_android_pip');

  static void enterPictureInPictureMode() {
    _channel.invokeMethod('enterPictureInPictureMode');
  }

  static void allowPIP(){
     _channel.invokeMethod('allowPIP');
  }

  static void disablePIP(){
     _channel.invokeMethod('allowPIP');
  }
}
