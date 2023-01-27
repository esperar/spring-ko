package esperer.kopring.global.filter

import com.fasterxml.jackson.databind.ObjectMapper
import esperer.kopring.global.error.ErrorCode
import esperer.kopring.global.error.exception.BusinessException
import esperer.kopring.global.error.response.ErrorResponse
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionFilter(
    private val objectMapper: ObjectMapper
): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: BusinessException) {
            sendError(response, e.errorCode)
        } catch (e: Exception) {
            sendError(response, ErrorCode.INTERVAL_SERVER_ERROR)
        }
    }

    private fun sendError(res: HttpServletResponse, errorCode: ErrorCode) {
        val errorResponse = ErrorResponse(errorCode.message, errorCode.status)
        val responseString = objectMapper.writeValueAsString(errorResponse)
        res.characterEncoding = "UTF-8"
        res.status = errorCode.status
        res.contentType = MediaType.APPLICATION_JSON_VALUE
        res.writer.write(responseString)
    }
}