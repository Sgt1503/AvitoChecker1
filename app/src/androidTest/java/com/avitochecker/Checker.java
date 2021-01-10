package com.avitochecker;

import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class Checker {
    private UiDevice device;
    @Test
    public void test() throws UiObjectNotFoundException, RemoteException, InterruptedException, JSONException {
        device = UiDevice.getInstance(InstrumentationRegistry
                .getInstrumentation());
        //cleaning workspace
        killApp();
        /* Entering apk and trying log/pass and Entering apk, trying log/pass
         * If method wouldn't find button it will through to the next method
         */
        enteringApp();
        checkerAndJSONcreator(log());
        killApp();
    }

    public void killApp() throws RemoteException, InterruptedException, UiObjectNotFoundException {
        device.pressHome();
        device.pressRecentApps();
        Thread.sleep(4000);
        /*
         * Checking and closing the application here, however, different views on different android versions.
         * I tested on origin UI of Android 5.1 and Android 7 with a Samsung Ui.
         *
         */
        if (device.findObject(new UiSelector().description("Dismiss Авито.")).exists())
            device.findObject(new UiSelector().description("Dismiss Авито.")).click();
        if (device.findObject(new UiSelector().textContains("ОЧИСТИТЬ ВСЕ")).exists())
            device.findObject(new UiSelector().textContains("ОЧИСТИТЬ ВСЕ")).click();
    }

    public void enteringApp() throws UiObjectNotFoundException {
        /*Possibility check of finding buttons.
         */
        device.pressHome();
        if(device.findObject(new UiSelector().textContains("Авито")).exists()) {
            device.findObject(new UiSelector().textContains("Авито")).click();
            if (device.findObject(new UiSelector().textContains("Профиль")).exists()) {
                device.findObject(new UiSelector().textContains("Профиль")).click();
                device.findObject(new UiSelector().textContains("Войти или зарегистрироваться")).click();
                device.findObject(new UiSelector().textContains("войти через телефон или почту")).click();
                UiObject enterLogin = device.findObject(new UiSelector().resourceId("com.avito.android:id/login_view"));
                enterLogin.legacySetText(log());
                UiObject enterPassword = device.findObject(new UiSelector().resourceId("com.avito.android:id/password_view"));
                enterPassword.legacySetText(log());
                device.findObject(new UiSelector().resourceId("com.avito.android:id/login_button")).click();
            }
        }
    }

    public String log(){
        /*Here you can try any login, that you want.
         * Actually there are no checking of Input Correctness.
         * It is assumed that input data will be already clean.
         */
        return "89123456789";
    }

    public void checkerAndJSONcreator(String log) throws JSONException {
        //Method writes data in json and through it to Logcat.
        if ((device.findObject(new UiSelector().resourceId("com.avito.android:id/body").textContains("Неправильный пароль")).exists())
                ||
                device.findObject(new UiSelector().resourceId("com.avito.android:id/body").textContains("Для вашей безопасности мы сбросили пароль от учётной записи")).exists()){
            JSONObject myObject = new JSONObject();
            myObject.put("login", log);
            myObject.put("exists", "true");
            System.out.println(myObject);
            
            
        }
        else if (device.findObject(new UiSelector().resourceId("com.avito.android:id/body").textContains("Неправильная почта")).exists()
                || device.findObject(new UiSelector().resourceId("com.avito.android:id/body").textContains("Восстановление доступа")).exists()
                || device.findObject(new UiSelector().resourceId("com.avito.android:id/body").textContains("Неправильный телефон")).exists()){
            JSONObject myObject = new JSONObject();
            myObject.put("login", log);
            myObject.put("exists", "false");
            System.out.println(myObject);
        }
    }
}
