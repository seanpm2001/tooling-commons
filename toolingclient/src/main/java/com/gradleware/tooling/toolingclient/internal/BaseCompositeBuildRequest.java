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

package com.gradleware.tooling.toolingclient.internal;

import java.io.File;
import java.util.Arrays;

import com.google.common.collect.ImmutableList;

import com.gradleware.tooling.toolingclient.CompositeBuildRequest;
import com.gradleware.tooling.toolingclient.GradleBuildIdentifier;

/**
 * Internal base class for all composite requests.
 *
 * @param <T> the result type
 * @param <SELF> self reference
 * @author Stefan Oehme
 */
abstract class BaseCompositeBuildRequest<T, SELF extends BaseCompositeBuildRequest<T, SELF>> extends BaseRequest<T, SELF>implements InspectableCompositeBuildRequest<T> {

    private ImmutableList<GradleBuildIdentifier> participants;
    private File gradleUserHomeDir;

    BaseCompositeBuildRequest(ExecutableToolingClient toolingClient) {
        super(toolingClient);
        this.participants = ImmutableList.of();
    }

    @Override
    public CompositeBuildRequest<T> gradleUserHomeDir(File gradleUserHomeDir) {
        this.gradleUserHomeDir = gradleUserHomeDir;
        return this;
    }

    @Override
    public File getGradleUserHomeDir() {
        return this.gradleUserHomeDir;
    }

    @Override
    public CompositeBuildRequest<T> participants(GradleBuildIdentifier... participants) {
        this.participants = ImmutableList.copyOf(participants);
        return getThis();
    }

    @Override
    public CompositeBuildRequest<T> addParticipants(GradleBuildIdentifier... participants) {
        this.participants = ImmutableList.<GradleBuildIdentifier> builder().addAll(this.participants).addAll(Arrays.asList(participants)).build();
        return getThis();
    }

    @Override
    public GradleBuildIdentifier[] getParticipants() {
        return this.participants.toArray(new GradleBuildIdentifier[0]);
    }

    @Override
    <S, S_SELF extends BaseRequest<S, S_SELF>> S_SELF copy(BaseRequest<S, S_SELF> request) {
        S_SELF copy = super.copy(request);
        if (copy instanceof BaseSingleBuildRequest) {
            @SuppressWarnings("rawtypes")
            BaseCompositeBuildRequest compositeRequest = (BaseCompositeBuildRequest) request;
            compositeRequest.participants(getParticipants());
        }
        return copy;
    }

}
