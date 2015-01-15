package com.gradleware.tooling.toolingmodel.repository.internal

import com.google.common.collect.ImmutableList
import com.gradleware.tooling.toolingmodel.repository.FixedRequestAttributes
import com.gradleware.tooling.junit.TestDirectoryProvider
import com.gradleware.tooling.spock.ToolingModelToolingClientSpecification
import com.gradleware.tooling.toolingclient.GradleDistribution
import org.junit.Rule

class DefaultModelRepositoryProviderTest extends ToolingModelToolingClientSpecification {

  @Rule
  TestDirectoryProvider directoryProvider = new TestDirectoryProvider();

  def setup() {
    directoryProvider.createFile('settings.gradle');
    directoryProvider.createFile('build.gradle') << 'task myTask {}'
  }

  def "getModelRepository"() {
    setup:
    def modelRepositoryProvider = new DefaultModelRepositoryProvider(toolingClient)

    def attributesOne = new FixedRequestAttributes(directoryProvider.testDirectory, null, GradleDistribution.fromBuild(), null, ImmutableList.of(), ImmutableList.of())
    def attributesTwo = new FixedRequestAttributes(directoryProvider.testDirectory, null, GradleDistribution.forVersion('1.12'), null, ImmutableList.of(), ImmutableList.of())

    assert modelRepositoryProvider.getModelRepository(attributesOne).is(modelRepositoryProvider.getModelRepository(attributesOne))
    assert modelRepositoryProvider.getModelRepository(attributesTwo).is(modelRepositoryProvider.getModelRepository(attributesTwo))
    assert !modelRepositoryProvider.getModelRepository(attributesOne).is(modelRepositoryProvider.getModelRepository(attributesTwo))
  }

}
