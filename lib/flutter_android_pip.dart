import 'package:flutter/services.dart';

class FlutterAndroidPip {
  static const MethodChannel _channel =
      const MethodChannel('flutter_android_pip');

  static void enterPictureInPictureMode() {
    _channel.invokeMethod('enterPictureInPictureMode');
  }

  static void enablePIP(){
     _channel.invokeMethod('enablePIP');
  }

  static void disablePIP(){
     _channel.invokeMethod('disablePIP');
  }
}
