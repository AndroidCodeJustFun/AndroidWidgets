
File f = new File('/Users/xiao/Work2017/xh_video_cx')
if (f.exists() && f.readable) {
    if (f.isDirectory()) {
        print(f.path)
    }
}