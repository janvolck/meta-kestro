DESCRIPTION = "Kestro Toolchain packages"
LICENSE = "CLOSED"

inherit packagegroup

MACHINE_EXTRA_INSTALL ?= ""

RDEPENDS_${PN} += " \
    qtmultimedia \
	qtserialport \
	avahi-daemon \
	mosquitto \
	net-snmp \
	python3-json \
	${MACHINE_EXTRA_INSTALL} \
"
