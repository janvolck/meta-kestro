inherit core-image

PR = "r0"

IMAGE_FEATURES += "ssh-server-openssh"
IMAGE_LINGUAS = ""

IMAGE_PKGS_AUDIO = " \
		alsa-utils \
		"

IMAGE_PKGS_WIFI = " \
		wpa-supplicant \
		"

IMAGE_PKGS_QT = " \
		qtmultimedia \
		gstreamer1.0 \
		gstreamer1.0-plugins-base \
		gstreamer1.0-plugins-good \
		gstreamer1.0-plugins-bad \
		gstreamer1.0-plugins-ugly \
		"

IMAGE_PGKS_SNMP = " \
		net-snmp-server-snmpd \
		net-snmp-server-snmptrapd \
		"

IMAGE_INSTALL += " \
		${@bb.utils.contains('IMAGE_FEATURES_KESTRO', 'audio', \
				     '${IMAGE_PKGS_AUDIO}', '', d)} \
		${@bb.utils.contains('IMAGE_FEATURES_KESTRO', 'qt', \
				     '${IMAGE_PKGS_QT}', '', d)} \
		${@bb.utils.contains('IMAGE_FEATURES_KESTRO', 'snmp', \
				     '${IMAGE_PGKS_SNMP}', '', d)} \
		${@bb.utils.contains('IMAGE_FEATURES_KESTRO', 'wifi', \
				     '${IMAGE_PKGS_WIFI}', '', d)} \
		bash \
		ethtool \
		file \
		hdparm \
		i2c-tools \
		ifupdown-scripts \
		iproute2 \
		iptables \
		kernel \
		ldd \
		ntimed \
		openssh-keygen \
		openssh-sftp-server \
		ppp \
		strace \
		tcpdump \
		udev-rules \
		usbutils \
		zip \
		fwdev \
		"

