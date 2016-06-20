/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gradleware.tooling.toolingmodel;

import org.gradle.api.Nullable;

import java.io.File;
import java.util.List;

/**
 * Describes a source directory in an Eclipse project.
 *
 * @author Etienne Studer
 */
public interface OmniEclipseSourceDirectory extends OmniClasspathEntry {

    /**
     * Returns the source directory.
     *
     * @return the source directory
     */
    File getDirectory();

    /**
     * Returns the relative path of this source directory.
     *
     * @return the relative path of this source directory
     */
    String getPath();


    /**
     * Returns the exclude patterns of this source directory.
     *
     * @return the exclude patterns
     */
    List<String> getExcludes();

    /**
     * Returns the include patterns of this directory.
     *
     * @return the include patterns
     */
    List<String> getIncludes();

    /**
     * Returns the output path of this source directory. If the source folder does not specify output
     * than this method returns {@code null}.
     *
     * @return the output path
     */
    @Nullable
    String getOutput();
}
