package wad.test.api.controller.order;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wad.test.api.ApiResponse;
import wad.test.api.controller.order.request.OrderCreateRequest;
import wad.test.api.controller.order.response.OrderResponse;
import wad.test.api.service.order.OrderService;

import java.time.LocalDateTime;

import static wad.test.api.ApiResponse.ok;

@RequiredArgsConstructor
@RestController
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/api/v1/orders/new")
    public ApiResponse<OrderResponse> createOrder(@Valid @RequestBody OrderCreateRequest request) {
        LocalDateTime registeredDateTime = LocalDateTime.now();
        return ok(orderService.createOrder(request.toServiceRequest(), registeredDateTime));
    }
}
