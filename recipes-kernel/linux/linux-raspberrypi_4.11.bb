FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

LINUX_VERSION ?= "4.11.10"

SRCREV = "77a83329550462336246d7b7194a7f68ff7a8a01"
SRC_URI = "git://github.com/raspberrypi/linux.git;protocol=git;branch=rpi-4.11.y \
           file://02-rpi-cm3-dts-64.patch \
"
require linux-raspberrypi.inc

# A LOADADDR is needed when building a uImage format kernel. This value is not
# set by default in rpi-4.8.y and later branches so we need to provide it
# manually. This value unused if KERNEL_IMAGETYPE is not uImage.
KERNEL_EXTRA_ARGS += "LOADADDR=0x00008000"
