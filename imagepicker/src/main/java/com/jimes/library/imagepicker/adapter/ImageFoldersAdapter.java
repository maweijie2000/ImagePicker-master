package com.jimes.library.imagepicker.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jimes.library.imagepicker.R;
import com.jimes.library.imagepicker.data.MediaFolder;
import com.jimes.library.imagepicker.manager.ConfigManager;

import java.util.List;

/**
 * 图片文件夹列表适配器
 */
public class ImageFoldersAdapter extends RecyclerView.Adapter<ImageFoldersAdapter.ViewHolder> {

    private Context mContext;
    private List<MediaFolder> mMediaFolderList;
    private int mCurrentImageFolderIndex;


    public ImageFoldersAdapter(Context context, List<MediaFolder> mediaFolderList, int position) {
        this.mContext = context;
        this.mMediaFolderList = mediaFolderList;
        this.mCurrentImageFolderIndex = position;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_recyclerview_folder, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final MediaFolder mediaFolder = mMediaFolderList.get(position);
        String folderCover = mediaFolder.getFolderCover();
        String folderName = mediaFolder.getFolderName();
        int imageSize = mediaFolder.getMediaFileList().size();

        if (!TextUtils.isEmpty(folderName)) {
            holder.mFolderName.setText(folderName);
        }

        if (ConfigManager.getInstance().isChinese(mContext))
            holder.tv_item_folderName.setText(String.format("全部", imageSize));
        else
            holder.tv_item_folderName.setText(String.format("All", imageSize));

        if (ConfigManager.getInstance().isChinese(mContext))
            holder.mImageSize.setText(String.format("%d张", imageSize));
        else
            holder.mImageSize.setText(String.format("%d", imageSize));

        if (mCurrentImageFolderIndex == position) {
            holder.mImageFolderCheck.setVisibility(View.VISIBLE);
        } else {
            holder.mImageFolderCheck.setVisibility(View.GONE);
        }
        //加载图片
        try {
            ConfigManager.getInstance().getImageLoader().loadImage(holder.mImageCover, folderCover);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (mImageFolderChangeListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCurrentImageFolderIndex = position;
                    notifyDataSetChanged();
                    mImageFolderChangeListener.onImageFolderChange(view, position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mMediaFolderList == null ? 0 : mMediaFolderList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageCover;
        private TextView mFolderName;
        private TextView mImageSize;
        private ImageView mImageFolderCheck;
        private TextView tv_item_folderName;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageCover = itemView.findViewById(R.id.iv_item_imageCover);
            mFolderName = itemView.findViewById(R.id.tv_item_folderName);
            mImageSize = itemView.findViewById(R.id.tv_item_imageSize);
            mImageFolderCheck = itemView.findViewById(R.id.iv_item_check);
            tv_item_folderName = itemView.findViewById(R.id.tv_item_folderName);
        }
    }

    /**
     * 接口回调，Item点击事件
     */
    private ImageFoldersAdapter.OnImageFolderChangeListener mImageFolderChangeListener;

    public void setOnImageFolderChangeListener(ImageFoldersAdapter.OnImageFolderChangeListener onItemClickListener) {
        this.mImageFolderChangeListener = onItemClickListener;
    }

    public interface OnImageFolderChangeListener {
        void onImageFolderChange(View view, int position);
    }
}
