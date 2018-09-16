SUMMARY = "Kestro Debug image"
DESCRIPTION = "Image that can be used to perform remote debugging on target devices."

require kestro-base-image.bb

IMAGE_INSTALL += " \
	gdbserver \
	"