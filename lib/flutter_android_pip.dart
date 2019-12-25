import 'dart:async';

import 'package:flutter/services.dart';

class FlutterAndroidPip {
  static const MethodChannel _channel =
      const MethodChannel('flutter_android_pip');

  static void enterPictureInPictureMode() {
    _channel.invokeMethod('enterPictureInPictureMode');
  }
}
