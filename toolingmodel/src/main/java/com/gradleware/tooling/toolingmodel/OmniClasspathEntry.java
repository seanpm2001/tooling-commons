/*
 * Copyright 2016 the original author or authors.
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

import java.util.List;

/**
 * A classpath entry in an Eclipse Java project.
 *
 * @author Stefan Oehme
 */
public interface OmniClasspathEntry {

    /**
     * Returns the classpath attributes of this entry.
     *
     * @return the attributes, never null
     */
    List<OmniClasspathAttribute> getClasspathAttributes();

    /**
     * Returns the access rules of this entry.
     *
     * @return the access rules, never null
     */
    List<OmniAccessRule> getAccessRules();
}
