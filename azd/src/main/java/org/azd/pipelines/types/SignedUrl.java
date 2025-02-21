package org.azd.pipelines.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Signed url for downloading this artifact
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignedUrl {
    /***
     * Timestamp when access expires.
     */
    @JsonProperty("signatureExpires")
    private String signatureExpires;
    /***
     * The URL to allow access to.
     */
    @JsonProperty("url")
    private String url;

    public String getSignatureExpires() {
        return signatureExpires;
    }

    public void setSignatureExpires(String signatureExpires) {
        this.signatureExpires = signatureExpires;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SignedUrl{" +
                "signatureExpires='" + signatureExpires + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
