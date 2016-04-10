package lj.model;

import java.util.Date;

public class Resource {
    private Integer id;

    private String uuidname;

    private String edgefile;

    private String nodefile;

    private String savepath;

    private Date uploadtime;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuidname() {
        return uuidname;
    }

    public void setUuidname(String uuidname) {
        this.uuidname = uuidname == null ? null : uuidname.trim();
    }

    public String getEdgefile() {
        return edgefile;
    }

    public void setEdgefile(String edgefile) {
        this.edgefile = edgefile == null ? null : edgefile.trim();
    }

    public String getNodefile() {
        return nodefile;
    }

    public void setNodefile(String nodefile) {
        this.nodefile = nodefile == null ? null : nodefile.trim();
    }

    public String getSavepath() {
        return savepath;
    }

    public void setSavepath(String savepath) {
        this.savepath = savepath == null ? null : savepath.trim();
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}