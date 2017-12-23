LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := gpuimage-library
LOCAL_LDFLAGS := -Wl,--build-id
LOCAL_LDLIBS := \
	-llog \

LOCAL_SRC_FILES := \
	D:\important_soft\android_studio_workspace\GaoFangMeiTu\library\jni\yuv-decoder.c \

LOCAL_C_INCLUDES += D:\important_soft\android_studio_workspace\GaoFangMeiTu\library\jni
LOCAL_C_INCLUDES += D:\important_soft\android_studio_workspace\GaoFangMeiTu\library\src\debug\jni

include $(BUILD_SHARED_LIBRARY)
