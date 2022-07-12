#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_movieapp_network_MyApp_getMyApp(JNIEnv *env, jclass obj) {
    return (*env)->NewStringUTF(env, "003fcbd729a751c39f31ecd676801be7");
}