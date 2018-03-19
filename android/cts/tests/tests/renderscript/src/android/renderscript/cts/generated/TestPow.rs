/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Don't edit this file!  It is auto-generated by frameworks/rs/api/generate.sh.

#pragma version(1)
#pragma rs java_package_name(android.renderscript.cts)

rs_allocation gAllocInExponent;

float __attribute__((kernel)) testPowFloatFloatFloat(float inBase, unsigned int x) {
    float inExponent = rsGetElementAt_float(gAllocInExponent, x);
    return pow(inBase, inExponent);
}

float2 __attribute__((kernel)) testPowFloat2Float2Float2(float2 inBase, unsigned int x) {
    float2 inExponent = rsGetElementAt_float2(gAllocInExponent, x);
    return pow(inBase, inExponent);
}

float3 __attribute__((kernel)) testPowFloat3Float3Float3(float3 inBase, unsigned int x) {
    float3 inExponent = rsGetElementAt_float3(gAllocInExponent, x);
    return pow(inBase, inExponent);
}

float4 __attribute__((kernel)) testPowFloat4Float4Float4(float4 inBase, unsigned int x) {
    float4 inExponent = rsGetElementAt_float4(gAllocInExponent, x);
    return pow(inBase, inExponent);
}
