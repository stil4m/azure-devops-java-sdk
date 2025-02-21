package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * Gets list of post deploy approvals snapshot.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionApprovals {
    /***
     * Gets or sets the approval options.
     */
    @JsonProperty("approvalOptions")
    private ApprovalOptions approvalOptions;
    /***
     * Gets or sets the approvals.
     */
    @JsonProperty("approvals")
    private List<ReleaseDefinitionApprovalStep> approvals;

    public ApprovalOptions getApprovalOptions() {
        return approvalOptions;
    }

    public void setApprovalOptions(ApprovalOptions approvalOptions) {
        this.approvalOptions = approvalOptions;
    }

    public List<ReleaseDefinitionApprovalStep> getApprovals() {
        return approvals;
    }

    public void setApprovals(List<ReleaseDefinitionApprovalStep> approvals) {
        this.approvals = approvals;
    }

    @Override
    public String toString() {
        return "ReleaseDefinitionApprovals{" +
                "approvalOptions=" + approvalOptions +
                ", approvals=" + approvals +
                '}';
    }

}
