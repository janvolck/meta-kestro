PACKAGECONFIG_append = " sql-sqlite"

OE_DEVICE_EXTRA ?= ""
OE_DEVICE_EXTRA_CONFIG ?= ""

QT_MKSPECS_PATH = "${D}${OE_QMAKE_PATH_QT_ARCHDATA}/mkspecs"
OE_DEVICE_EXTRA_PATH = "${QT_MKSPECS_PATH}/oe-device-extra.pri"

do_install_prepend() {

    install -d ${QT_MKSPECS_PATH}
    touch ${OE_DEVICE_EXTRA_PATH}

    if [ -n "${OE_DEVICE_EXTRA}" ]; then
        echo "${OE_DEVICE_EXTRA}" >> ${OE_DEVICE_EXTRA_PATH}
    fi

    if [ -n "${OE_DEVICE_EXTRA_CONFIG}" ]; then
        echo "CONFIG +=${OE_DEVICE_EXTRA_CONFIG}" >> ${OE_DEVICE_EXTRA_PATH}
    fi
}