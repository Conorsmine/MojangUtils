package mojangson;

import mojangson.data.INBTData;
import mojangson.path.NBTPath;

public class NBTQueryResult {

    private final NBTPath path;
    private final INBTData<?> data;

    NBTQueryResult(NBTPath path, INBTData<?> data) {
        this.path = path;
        this.data = data;
    }

    public NBTPath getPath() {
        return path;
    }

    public INBTData<?> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "NBTQueryResult{" +
                "path=" + path +
                ", data=" + data.stringify() +
                '}';
    }
}
