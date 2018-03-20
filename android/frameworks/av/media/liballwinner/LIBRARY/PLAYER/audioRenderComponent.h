
#ifndef AUDIO_RENDER_H
#define AUDIO_RENDER_H

#include "player_i.h"
#include "audioDecComponent.h"

typedef void* AudioRenderComp;

AudioRenderComp* AudioRenderCompCreate(void);

int AudioRenderCompDestroy(AudioRenderComp* a);

int AudioRenderCompStart(AudioRenderComp* a);

int AudioRenderCompStop(AudioRenderComp* a);

int AudioRenderCompPause(AudioRenderComp* a);

enum EPLAYERSTATUS AudioRenderCompGetStatus(AudioRenderComp* a);

int AudioRenderCompReset(AudioRenderComp* a);

int AudioRenderCompSetEOS(AudioRenderComp* a);

int AudioRenderCompSetCallback(AudioRenderComp* a, PlayerCallback callback, void* pUserData);

int AudioRenderCompSetTimer(AudioRenderComp* a, AvTimer* timer);

int AudioRenderCompSetAudioSink(AudioRenderComp* a, void* pAudioSink);

int AudioRenderCompSetDecodeComp(AudioRenderComp* a, AudioDecComp* d);

int64_t AudioRenderCompCacheTimeUs(AudioRenderComp* a);

int AudioRenderCompGetAudioOutBalance(AudioRenderComp* a);

//* set audio balance, 1 means left channel, 2 means right channel, 3 means stereo.
int AudioRenderCompSetAudioOutBalance(AudioRenderComp* a, int nBalance);

//* set audio mute, bMute = 1 means mute audio, 0 means resume from mute.
int AudioRenderCompSetAudioMute(AudioRenderComp* a, int bMute);

//* get the audio mute setting, 1 means audio muted, 0 means not muted.
int AudioRenderCompGetAudioMuteFlag(AudioRenderComp* a);

int AudioRenderCompSetForceWriteToDeviceFlag(AudioRenderComp* a, int bForceFlag);

int AudioRenderCompSetVolume(AudioRenderComp* a, float volume);
int AudioRenderCompGetVolume(AudioRenderComp* a, float *volume);


#endif

