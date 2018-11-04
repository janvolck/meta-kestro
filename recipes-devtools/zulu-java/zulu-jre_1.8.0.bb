
def get_recipe(d):
   target_arch = d.getVar('TARGET_ARCH', True)
   if target_arch == "arm":
       if d.getVar('TARGET_FPU', True) in [ 'hard' ]:
           return "zulu-ezre-aarch32hf"
       else:
           return "zulu-ezre-aarch32sf"
   elif target_arch == "aarch64":
       return "zulu-ezre-aarch64"
   elif target_arch == "x86_64":
       bb.error("Target architecture '%s' is not supported by the meta-proxima layer" %target_arch)
       raise bb.parse.SkipPackage("Target architecture '%s' is not supported by the meta-proxima layer" %target_arch)
   elif target_arch in ["i386", "i486", "i586", "i686"]:
       bb.error("Target architecture '%s' is not supported by the meta-proxima layer" %target_arch)
       raise bb.parse.SkipPackage("Target architecture '%s' is not supported by the meta-proxima layer" %target_arch)
   else:
       bb.error("Target architecture '%s' is not supported by the meta-proxima layer" %target_arch)
       raise bb.parse.SkipPackage("Target architecture '%s' is not supported by the meta-proxima layer" %target_arch)

recipe = "${@get_recipe(d)}" 
require ${recipe}.bb

