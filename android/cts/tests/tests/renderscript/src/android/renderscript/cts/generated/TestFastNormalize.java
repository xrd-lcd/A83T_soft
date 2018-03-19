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

package android.renderscript.cts;

import android.renderscript.Allocation;
import android.renderscript.RSRuntimeException;
import android.renderscript.Element;

import java.util.Arrays;

public class TestFastNormalize extends RSBaseCompute {

    private ScriptC_TestFastNormalize script;
    private ScriptC_TestFastNormalizeRelaxed scriptRelaxed;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        script = new ScriptC_TestFastNormalize(mRS);
        scriptRelaxed = new ScriptC_TestFastNormalizeRelaxed(mRS);
    }

    public class ArgumentsFloatFloat {
        public float inV;
        public Target.Floaty out;
    }

    private void checkFastNormalizeFloatFloat() {
        Allocation inV = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 1, 0x9f8882ecl, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            script.forEach_testFastNormalizeFloatFloat(inV, out);
            verifyResultsFastNormalizeFloatFloat(inV, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFastNormalizeFloatFloat: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 1), INPUTSIZE);
            scriptRelaxed.forEach_testFastNormalizeFloatFloat(inV, out);
            verifyResultsFastNormalizeFloatFloat(inV, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFastNormalizeFloatFloat: " + e.toString());
        }
    }

    private void verifyResultsFastNormalizeFloatFloat(Allocation inV, Allocation out, boolean relaxed) {
        float[] arrayInV = new float[INPUTSIZE * 1];
        Arrays.fill(arrayInV, (float) 42);
        inV.copyTo(arrayInV);
        float[] arrayOut = new float[INPUTSIZE * 1];
        Arrays.fill(arrayOut, (float) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            ArgumentsFloatFloat args = new ArgumentsFloatFloat();
            // Create the appropriate sized arrays in args
            // Fill args with the input values
            args.inV = arrayInV[i];
            Target target = new Target(relaxed);
            CoreMathVerifier.computeFastNormalize(args, target);

            // Compare the expected outputs to the actual values returned by RS.
            boolean valid = true;
            if (!args.out.couldBe(arrayOut[i])) {
                valid = false;
            }
            if (!valid) {
                if (!errorFound) {
                    errorFound = true;
                    message.append("Input inV: ");
                    appendVariableToMessage(message, arrayInV[i]);
                    message.append("\n");
                    message.append("Expected output out: ");
                    appendVariableToMessage(message, args.out);
                    message.append("\n");
                    message.append("Actual   output out: ");
                    appendVariableToMessage(message, arrayOut[i]);
                    if (!args.out.couldBe(arrayOut[i])) {
                        message.append(" FAIL");
                    }
                    message.append("\n");
                    message.append("Errors at");
                }
                message.append(" [");
                message.append(Integer.toString(i));
                message.append("]");
            }
        }
        assertFalse("Incorrect output for checkFastNormalizeFloatFloat" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    public class ArgumentsFloatNFloatN {
        public float[] inV;
        public Target.Floaty[] out;
    }

    private void checkFastNormalizeFloat2Float2() {
        Allocation inV = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 2, 0x573db70l, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 2), INPUTSIZE);
            script.forEach_testFastNormalizeFloat2Float2(inV, out);
            verifyResultsFastNormalizeFloat2Float2(inV, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFastNormalizeFloat2Float2: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 2), INPUTSIZE);
            scriptRelaxed.forEach_testFastNormalizeFloat2Float2(inV, out);
            verifyResultsFastNormalizeFloat2Float2(inV, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFastNormalizeFloat2Float2: " + e.toString());
        }
    }

    private void verifyResultsFastNormalizeFloat2Float2(Allocation inV, Allocation out, boolean relaxed) {
        float[] arrayInV = new float[INPUTSIZE * 2];
        Arrays.fill(arrayInV, (float) 42);
        inV.copyTo(arrayInV);
        float[] arrayOut = new float[INPUTSIZE * 2];
        Arrays.fill(arrayOut, (float) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            ArgumentsFloatNFloatN args = new ArgumentsFloatNFloatN();
            // Create the appropriate sized arrays in args
            args.inV = new float[2];
            args.out = new Target.Floaty[2];
            // Fill args with the input values
            for (int j = 0; j < 2 ; j++) {
                args.inV[j] = arrayInV[i * 2 + j];
            }
            Target target = new Target(relaxed);
            CoreMathVerifier.computeFastNormalize(args, target);

            // Compare the expected outputs to the actual values returned by RS.
            boolean valid = true;
            for (int j = 0; j < 2 ; j++) {
                if (!args.out[j].couldBe(arrayOut[i * 2 + j])) {
                    valid = false;
                }
            }
            if (!valid) {
                if (!errorFound) {
                    errorFound = true;
                    for (int j = 0; j < 2 ; j++) {
                        message.append("Input inV: ");
                        appendVariableToMessage(message, arrayInV[i * 2 + j]);
                        message.append("\n");
                    }
                    for (int j = 0; j < 2 ; j++) {
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out[j]);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 2 + j]);
                        if (!args.out[j].couldBe(arrayOut[i * 2 + j])) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                    }
                    message.append("Errors at");
                }
                message.append(" [");
                message.append(Integer.toString(i));
                message.append("]");
            }
        }
        assertFalse("Incorrect output for checkFastNormalizeFloat2Float2" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    private void checkFastNormalizeFloat3Float3() {
        Allocation inV = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 3, 0xfb8efc4el, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 3), INPUTSIZE);
            script.forEach_testFastNormalizeFloat3Float3(inV, out);
            verifyResultsFastNormalizeFloat3Float3(inV, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFastNormalizeFloat3Float3: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 3), INPUTSIZE);
            scriptRelaxed.forEach_testFastNormalizeFloat3Float3(inV, out);
            verifyResultsFastNormalizeFloat3Float3(inV, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFastNormalizeFloat3Float3: " + e.toString());
        }
    }

    private void verifyResultsFastNormalizeFloat3Float3(Allocation inV, Allocation out, boolean relaxed) {
        float[] arrayInV = new float[INPUTSIZE * 4];
        Arrays.fill(arrayInV, (float) 42);
        inV.copyTo(arrayInV);
        float[] arrayOut = new float[INPUTSIZE * 4];
        Arrays.fill(arrayOut, (float) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            ArgumentsFloatNFloatN args = new ArgumentsFloatNFloatN();
            // Create the appropriate sized arrays in args
            args.inV = new float[3];
            args.out = new Target.Floaty[3];
            // Fill args with the input values
            for (int j = 0; j < 3 ; j++) {
                args.inV[j] = arrayInV[i * 4 + j];
            }
            Target target = new Target(relaxed);
            CoreMathVerifier.computeFastNormalize(args, target);

            // Compare the expected outputs to the actual values returned by RS.
            boolean valid = true;
            for (int j = 0; j < 3 ; j++) {
                if (!args.out[j].couldBe(arrayOut[i * 4 + j])) {
                    valid = false;
                }
            }
            if (!valid) {
                if (!errorFound) {
                    errorFound = true;
                    for (int j = 0; j < 3 ; j++) {
                        message.append("Input inV: ");
                        appendVariableToMessage(message, arrayInV[i * 4 + j]);
                        message.append("\n");
                    }
                    for (int j = 0; j < 3 ; j++) {
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out[j]);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 4 + j]);
                        if (!args.out[j].couldBe(arrayOut[i * 4 + j])) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                    }
                    message.append("Errors at");
                }
                message.append(" [");
                message.append(Integer.toString(i));
                message.append("]");
            }
        }
        assertFalse("Incorrect output for checkFastNormalizeFloat3Float3" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    private void checkFastNormalizeFloat4Float4() {
        Allocation inV = createRandomAllocation(mRS, Element.DataType.FLOAT_32, 4, 0xf1aa1d2cl, false);
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 4), INPUTSIZE);
            script.forEach_testFastNormalizeFloat4Float4(inV, out);
            verifyResultsFastNormalizeFloat4Float4(inV, out, false);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFastNormalizeFloat4Float4: " + e.toString());
        }
        try {
            Allocation out = Allocation.createSized(mRS, getElement(mRS, Element.DataType.FLOAT_32, 4), INPUTSIZE);
            scriptRelaxed.forEach_testFastNormalizeFloat4Float4(inV, out);
            verifyResultsFastNormalizeFloat4Float4(inV, out, true);
        } catch (Exception e) {
            throw new RSRuntimeException("RenderScript. Can't invoke forEach_testFastNormalizeFloat4Float4: " + e.toString());
        }
    }

    private void verifyResultsFastNormalizeFloat4Float4(Allocation inV, Allocation out, boolean relaxed) {
        float[] arrayInV = new float[INPUTSIZE * 4];
        Arrays.fill(arrayInV, (float) 42);
        inV.copyTo(arrayInV);
        float[] arrayOut = new float[INPUTSIZE * 4];
        Arrays.fill(arrayOut, (float) 42);
        out.copyTo(arrayOut);
        StringBuilder message = new StringBuilder();
        boolean errorFound = false;
        for (int i = 0; i < INPUTSIZE; i++) {
            ArgumentsFloatNFloatN args = new ArgumentsFloatNFloatN();
            // Create the appropriate sized arrays in args
            args.inV = new float[4];
            args.out = new Target.Floaty[4];
            // Fill args with the input values
            for (int j = 0; j < 4 ; j++) {
                args.inV[j] = arrayInV[i * 4 + j];
            }
            Target target = new Target(relaxed);
            CoreMathVerifier.computeFastNormalize(args, target);

            // Compare the expected outputs to the actual values returned by RS.
            boolean valid = true;
            for (int j = 0; j < 4 ; j++) {
                if (!args.out[j].couldBe(arrayOut[i * 4 + j])) {
                    valid = false;
                }
            }
            if (!valid) {
                if (!errorFound) {
                    errorFound = true;
                    for (int j = 0; j < 4 ; j++) {
                        message.append("Input inV: ");
                        appendVariableToMessage(message, arrayInV[i * 4 + j]);
                        message.append("\n");
                    }
                    for (int j = 0; j < 4 ; j++) {
                        message.append("Expected output out: ");
                        appendVariableToMessage(message, args.out[j]);
                        message.append("\n");
                        message.append("Actual   output out: ");
                        appendVariableToMessage(message, arrayOut[i * 4 + j]);
                        if (!args.out[j].couldBe(arrayOut[i * 4 + j])) {
                            message.append(" FAIL");
                        }
                        message.append("\n");
                    }
                    message.append("Errors at");
                }
                message.append(" [");
                message.append(Integer.toString(i));
                message.append("]");
            }
        }
        assertFalse("Incorrect output for checkFastNormalizeFloat4Float4" +
                (relaxed ? "_relaxed" : "") + ":\n" + message.toString(), errorFound);
    }

    public void testFastNormalize() {
        checkFastNormalizeFloatFloat();
        checkFastNormalizeFloat2Float2();
        checkFastNormalizeFloat3Float3();
        checkFastNormalizeFloat4Float4();
    }
}
