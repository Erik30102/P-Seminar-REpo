package com.Pseminar.Assets;

public abstract class Asset {
    private transient int numberOfHandlers = 0;
    private transient int id;

    public enum AssetType {
        TEXTURE2D,
    }

    public final void SetId(int id) {
        this.id = id;
    }

    public int GetAssetId() {
        return this.id;
    }

    public abstract AssetType GetAssetType();
    public abstract void OnDispose();

    public void Handle() {
        numberOfHandlers++;
    }

    public void RemoveHandle() {
        numberOfHandlers--;

        if(numberOfHandlers <= 0) {
            OnDispose();
            ProjectInfo.GetProjectInfo().GetAssetManager().DisposeAsset(this.id);
        }
    }

}
