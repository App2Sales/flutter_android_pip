package ca.ztek.flutterandroidpip;

import android.annotation.TargetApi;
import android.os.Build;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugin.common.PluginRegistry.UserLeaveHintListener;

/** FlutterAndroidPipPlugin */
public class FlutterAndroidPipPlugin implements MethodCallHandler, UserLeaveHintListener {
  /** Plugin registration. */
  static Registrar _registrar;
  private Boolean _pipEnabled = false;
  private static FlutterAndroidPipPlugin _instance;
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_android_pip");
    channel.setMethodCallHandler(FlutterAndroidPipPlugin.getInstance());
    _registrar = registrar;
    _registrar.addUserLeaveHintListener(FlutterAndroidPipPlugin.getInstance());
  }

  public static FlutterAndroidPipPlugin getInstance() 
  { 
      if (_instance == null) 
        _instance = new FlutterAndroidPipPlugin(); 

      return _instance; 
  } 

  public void setPIP(boolean canEnterPip){
    _pipEnabled = canEnterPip;
  }

  @Override
  public void onUserLeaveHint() {
    System.out.println("User left!");
    enterPIP();
   }

  public void enterPIP(){
    if (Build.VERSION.SDK_INT > 24 && _pipEnabled)
    _registrar.activity().enterPictureInPictureMode();
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    switch (call.method) {
      case "enterPictureInPictureMode":
        enterPIP();
        break;
      case "enablePIP":
      setPIP(true);
      break;
      case "disablePIP":
      setPIP(false);
      break;
      default:
        result.notImplemented();
        break;
    }
    }
  }

