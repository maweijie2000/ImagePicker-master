# ImagePicker-master

	dependencies {
	        implementation 'com.github.maweijie2000:ImagePicker-master:ImageSelecter'
	}


##########


  ImagePicker.getInstance()
                        .setTitle("标题")//设置标题
                        .showCamera(true)//设置是否显示拍照按钮
                        .showImage(true)//设置是否展示图片
                        .showVideo(true)//设置是否展示视频
                        .showVideo(true)//设置是否展示视频
                        .setSingleType(true)//设置图片视频不能同时选择
                        .setMaxCount(9)//设置最大选择图片数目(默认为 1，单选)
                        .setImagePaths(mImageList)//保存上一次选择图片的状态，如果不需要可以忽略
                        .setImageLoader(new GlideLoader())//设置自定义图片加载器
                        .start(MainActivity.this, REQUEST_SELECT_IMAGES_CODE);//REQEST_SELECT_IMAGES_CODE 为 Intent 调用的 requestCode


#########################



 public class GlideLoader implements ImageLoader {
                //to do something 可以参考 Demo 用法

            }
                        
######################



   ImagePicker.getInstance()
                        .setTitle("标题")//设置标题
                        .showCamera(true)//设置是否显示拍照按钮
                        .showImage(true)//设置是否展示图片
                        .showVideo(true)//设置是否展示视频
                        .showVideo(true)//设置是否展示视频
                        .setSingleType(true)//设置图片视频不能同时选择
                        .setMaxCount(9)//设置最大选择图片数目(默认为 1，单选)
                        .setImagePaths(mImageList)//保存上一次选择图片的状态，如果不需要可以忽略
                        .setImageLoader(new GlideLoader())//设置自定义图片加载器
                        .start(MainActivity.this, REQUEST_SELECT_IMAGES_CODE);//REQEST_SELECT_IMAGES_CODE 为 Intent 调用的 requestCode
                        
                        
##############################



  @Override
                protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                    if (requestCode == REQUEST_SELECT_IMAGES_CODE && resultCode == RESULT_OK) {
                        List<String> imagePaths = data.getStringArrayListExtra(ImagePicker.EXTRA_SELECT_IMAGES);
                    }
                }
                        
                        
                       
