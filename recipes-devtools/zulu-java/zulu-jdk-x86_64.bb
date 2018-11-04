
PV = "1.8.0"
PV_UPDATE = "181"
VERSION = "8.31.0.1"
BUILD_NUMBER = "8.0.181"
SUFFIX = "linux_x64"

SUMMARY = "Azul Zulu Java Development Kit (JDK) binaries"
DESCRIPTION = "This the Embedded JDK for the 64 bit Intel architecture from \
 Azul Systems Inc. It is created using OpenJDK code, which is licensed under \
 GPLv2 and various other third party licenses. Azul offers a variety of \
 support plans, as well as patent indemnification and guarantees against \
 the risk of open source viral contamination, as part of its Zulu \
 Embedded commercial offerings."

BBCLASSEXTEND = "native"

LICENSE = "GPL-2.0-with-classpath-exception"
LIC_FILES_CHKSUM = "file://zulu${VERSION}-jdk${BUILD_NUMBER}-${SUFFIX}/LICENSE;md5=3e0b59f8fac05c3c03d4a26bbda13f8f"

SRC_URI="http://cdn.azul.com/zulu/bin/zulu${VERSION}-jdk${BUILD_NUMBER}-${SUFFIX}.tar.gz"

SRC_URI[md5sum] = "64270772bfaaced5611d754cd022c32e"
SRC_URI[sha256sum] = "ccc9cff02b8f57ff3bc83c4580a5e5948460212dfbd21f1b4b1702b5bbf81079"

PR = "u${PV_UPDATE}"
S = "${WORKDIR}"

do_install () {
  install -d -m 0755 ${D}${datadir}/zulu-${PV}_${PV_UPDATE}
  cp -a ${S}/zulu${VERSION}-jdk${BUILD_NUMBER}-${SUFFIX}/* ${D}${datadir}/zulu-${PV}_${PV_UPDATE}
  
  install -d -m 0755 ${D}${bindir}
  ln -sf ${datadir}/zulu-${PV}_${PV_UPDATE}/bin/java ${D}${bindir}/java
}

# All the files are provided in a binaray package, and keeping all the
# files in a single package causes packaging QA errors and warnings.
# Avoid these packaging failure by skiping all the QA checks
INSANE_SKIP_${PN} = "${ERROR_QA} ${WARN_QA}"

FILES_${PN} = "/usr/"
RPROVIDES_${PN} = "virtual/java"
PROVIDES += "virtual/java"

DEPENDS = "alsa-lib libxi libxrender libxtst"

inherit update-alternatives

ALTERNATIVE_PRIORITY = "100"

ALTERNATIVE_${PN} = "java javac"
ALTERNATIVE_LINK_NAME[java] = "${bindir}/java"
ALTERNATIVE_TARGET[java] = "${JDK_HOME}/bin/java"

ALTERNATIVE_LINK_NAME[javac] = "${bindir}/javac"
ALTERNATIVE_TARGET[javac] = "${JDK_HOME}/bin/javac"
