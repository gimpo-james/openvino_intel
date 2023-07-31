require opencl-clang.inc

SRC_URI:append = " file://0001-don-t-redefine-LLVM_TABLEGEN_EXE.patch \
           "
SRCREV = "06c7c0d7f5cbd13810d79489a533fa6c5b6c7d9f"

BRANCH = "ocl-open-140"

DEPENDS += " spirv-llvm-translator"

EXTRA_OECMAKE += "\
                  -DLLVM_TABLEGEN_EXE=${STAGING_BINDIR_NATIVE}/llvm-tblgen \
                  -DCMAKE_SKIP_RPATH=TRUE \
                  -DPREFERRED_LLVM_VERSION=${LLVMVERSION} \
                  "

do_install:append:class-native() {
        install -d ${D}${bindir}
        install -m 0755 ${B}/linux_linker/linux_resource_linker ${D}${bindir}/
}
