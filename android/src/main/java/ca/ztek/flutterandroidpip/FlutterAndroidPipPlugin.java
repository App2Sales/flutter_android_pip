package ca.ztek.flutterandroidpip;

import android.annotation.TargetApi;
import android.os.Build;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterAndroidPipPlugin */
public class FlutterAndroidPipPlugin implements MethodCallHandler {
  /** Plugin registration. */
  static Registrar _registrar;
  private Boolean _pipEnabled = false;
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_android_pip");
    channel.setMethodCallHandler(new FlutterAndroidPipPlugin());
    _registrar = registrar;
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    switch (call.method) {
      case "enterPictureInPictureMode":
      if (Build.VERSION.SDK_INT > 24 && _pipEnabled)
        _registrar.activity().enterPictureInPictureMode();
        result.success("Android " + android.os.Build.VERSION.RELEASE);
        break;
      case "enablePIP":
       _pipEnabled = true;
      break;
      case "disablePIP":
      _pipEnabled = false;
      break;
      default:
        result.notImplemented();
        break;
    }
    }
  }

