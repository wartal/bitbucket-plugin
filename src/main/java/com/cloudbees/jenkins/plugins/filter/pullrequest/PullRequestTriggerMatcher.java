/*
 * The MIT License
 *
 * Copyright (c) 2016 CloudBees, Inc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.cloudbees.jenkins.plugins.filter.pullrequest;

import com.cloudbees.jenkins.plugins.BitbucketEvent;
import com.cloudbees.jenkins.plugins.filter.BitbucketEventTriggerMatcher;
import com.cloudbees.jenkins.plugins.filter.BitbucketTriggerFilter;

/**
 * {link @code PullRequestTriggerMatcher} for {link @BitbucketEventTriggerMatcher}
 * @since August 1, 2016
 * @version 2.0
 */
public class PullRequestTriggerMatcher implements BitbucketEventTriggerMatcher {
    @Override
    public boolean matchesAction(BitbucketEvent bitbucketEvent, BitbucketTriggerFilter triggerFilter) {
        if(BitbucketEvent.PULL_REQUEST_ACTIONS.APPROVED.equals(bitbucketEvent.getAction()) &&
                triggerFilter.getActionFilter() instanceof PullRequestApprovedActionFilter) {
            return true;
        } else if (BitbucketEvent.PULL_REQUEST_ACTIONS.CREATED.equals(bitbucketEvent.getAction()) &&
                triggerFilter.getActionFilter() instanceof  PullRequestCreatedActionFilter) {
            return true;
        } else if (BitbucketEvent.PULL_REQUEST_ACTIONS.UPDATED.equals(bitbucketEvent.getAction()) &&
                triggerFilter.getActionFilter() instanceof  PullRequestUpdatedActionFilter) {
            return true;
        } else if (BitbucketEvent.PULL_REQUEST_ACTIONS.FULFILLED.equals(bitbucketEvent.getAction()) &&
                triggerFilter.getActionFilter() instanceof  PullRequestFulfilledActionFilter) {
            return true;
        }
        return false;
    }

}
