package esperer.kopring.global.aws.s3.service

import org.springframework.web.multipart.MultipartFile

interface S3Service {
    fun uploadFile(file: MultipartFile, dirName: String): String
    fun deleteFile(fileName: String)
}