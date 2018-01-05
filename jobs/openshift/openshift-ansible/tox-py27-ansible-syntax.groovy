#!/usr/bin/env groovy
@Library("release-library@master")
import com.redhat.openshift.PipelineImageTestStep

import static com.redhat.openshift.BuildPipelineConfiguration.TEST_BINARIES_TAG

testPipeline([new PipelineImageTestStep(
  tag: TEST_BINARIES_TAG,
  env: [ANSIBLE_CACHE_PLUGIN: "memory"],
  commands: ["./.tox/py27-ansible_syntax/bin/python setup.py ansible_syntax"]
)])