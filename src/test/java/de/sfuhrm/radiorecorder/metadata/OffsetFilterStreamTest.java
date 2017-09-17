/*
 * Copyright 2017 Stephan Fuhrmann.
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
package de.sfuhrm.radiorecorder.metadata;

import java.io.IOException;
import java.io.InputStream;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Mockito based test for {@link OffsetFilterStream}.
 *
 * @author Stephan Fuhrmann
 */
@RunWith(MockitoJUnitRunner.class)
public class OffsetFilterStreamTest {

    @Mock
    InputStream inputStream;

    @Test
    public void create() throws IOException {
        OffsetFilterStream ofs = new OffsetFilterStream(inputStream);
        assertEquals(0, ofs.getOffset());
        assertEquals(0, ofs.getMarked());
    }

    @Test
    public void readWithOneByte() throws IOException {
        when(inputStream.read()).thenReturn(42);
        OffsetFilterStream ofs = new OffsetFilterStream(inputStream);
        assertEquals(0, ofs.getOffset());
        assertEquals(0, ofs.getMarked());

        int c = ofs.read();
        assertEquals(42, c);
        
        assertEquals(1, ofs.getOffset());
        assertEquals(0, ofs.getMarked());
        
        verify(inputStream).read();
    }
    
    @Test
    public void readWithArray() throws IOException {
        byte[] array = new byte[16];
        
        when(inputStream.read(any(), anyInt(), anyInt())).thenReturn(16);
        OffsetFilterStream ofs = new OffsetFilterStream(inputStream);
        assertEquals(0, ofs.getOffset());
        assertEquals(0, ofs.getMarked());

        int c = ofs.read(array, 0, 16);
        assertEquals(16, c);
        
        assertEquals(16, ofs.getOffset());
        assertEquals(0, ofs.getMarked());
        
        verify(inputStream).read(array, 0, 16);
    }
    
    @Test
    public void readWithArrayShortRead() throws IOException {
        byte[] array = new byte[16];
        
        when(inputStream.read(any(), anyInt(), anyInt())).thenReturn(5);
        OffsetFilterStream ofs = new OffsetFilterStream(inputStream);
        assertEquals(0, ofs.getOffset());
        assertEquals(0, ofs.getMarked());

        int c = ofs.read(array, 0, 16);
        assertEquals(5, c);
        
        assertEquals(5, ofs.getOffset());
        assertEquals(0, ofs.getMarked());
        
        verify(inputStream).read(array, 0, 16);
    }
    
    @After
    public void validate() {
        validateMockitoUsage();
    }
}
