
def get_recipe(d):
   native_arch = d.getVar('BUILD_ARCH', True)
   if native_arch == "x86_64":
       return "zulu-jdk-x86_64"
   elif native_arch == "arm":
       bb.error("Native architecture '%s' is not supported by the meta-proxima layer" %native_arch)
       raise bb.parse.SkipPackage("Native architecture '%s' is not supported by the meta-proxima layer" %native_arch)       
   elif native_arch == "aarch64":
       bb.error("Native architecture '%s' is not supported by the meta-proxima layer" %native_arch)
       raise bb.parse.SkipPackage("Native architecture '%s' is not supported by the meta-proxima layer" %native_arch)
   elif native_arch in ["i386", "i486", "i586", "i686"]:
       bb.error("Native architecture '%s' is not supported by the meta-proxima layer" %native_arch)
       raise bb.parse.SkipPackage("Native architecture '%s' is not supported by the meta-proxima layer" %native_arch)
   else:
       bb.error("Native architecture '%s' is not supported by the meta-proxima layer" %native_arch)
       raise bb.parse.SkipPackage("Native architecture '%s' is not supported by the meta-proxima layer" %native_arch)

recipe = "${@get_recipe(d)}" 
require ${recipe}.bb

