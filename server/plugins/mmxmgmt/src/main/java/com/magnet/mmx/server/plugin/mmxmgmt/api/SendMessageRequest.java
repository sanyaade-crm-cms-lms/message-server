/*   Copyright (c) 2015 Magnet Systems, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.magnet.mmx.server.plugin.mmxmgmt.api;

import com.magnet.mmx.server.plugin.mmxmgmt.api.push.Target;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 */
public class SendMessageRequest {
  private List<String> recipientUsernames;
  private String deviceId;
  private Map<String, String> content;
  private boolean receipt;
  private String replyTo;
  private Target target;


  public List<String> getRecipientUsernames() {
    return recipientUsernames;
  }

  public void setRecipientUsernames(List<String> recipientUsername) {
    this.recipientUsernames = recipientUsername;
  }

  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public Map<String, String> getContent() {
    return content;
  }

  public void setContent(Map<String, String> content) {
    this.content = content;
  }

  public boolean isReceipt() {
    return receipt;
  }

  public void setReceipt(boolean receipt) {
    this.receipt = receipt;
  }

  public String getReplyTo() {
    return replyTo;
  }

  public void setReplyTo(String replyTo) {
    this.replyTo = replyTo;
  }


  public Target getTarget() {
    return target;
  }

  public void setTarget(Target target) {
    this.target = target;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("SendMessageRequest{");
    sb.append("content=").append(content);
    sb.append(", recipientUsernames=").append(recipientUsernames);
    sb.append(", deviceId='").append(deviceId).append('\'');
    sb.append(", receipt=").append(receipt);
    sb.append(", replyTo='").append(replyTo).append('\'');
    sb.append(", target=").append(target);
    sb.append('}');
    return sb.toString();
  }
}
