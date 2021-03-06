/*
 * Copyright 2011 JBoss, by Red Hat, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.errai.ioc.support.bus.tests.client.res;

import org.jboss.errai.ioc.client.api.AfterInitialization;
import org.jboss.errai.ioc.client.api.InitBallot;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Mike Brock
 */
@Singleton
public class LifecycleBean {
  @Inject private InitBallot<LifecycleBean> ballot;
  private boolean afterInitCalled;

  @PostConstruct
  public void postConstruct() {
    ballot.voteForInit();
  }

  @AfterInitialization
  private void afterInit() {
    afterInitCalled = true;
  }

  public InitBallot<LifecycleBean> getBallot() {
    return ballot;
  }

  public boolean isAfterInitCalled() {
    return afterInitCalled;
  }
}
