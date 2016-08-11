			function getDetailsOnFilterSelection() {
				var filters = {}
				filters["selectedFeatures"] = $(
						"input[type='checkbox']:checked").map(function() {
					return this.value;
				}).get()
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/getDetailsOnFilterSelection",
					data : JSON.stringify(filters),
					dataType : 'html',
					timeout : 100000,
					success : function(data) {
						console.log("SUCCESS: ", data);
						displayFilteredOffers(data);
					},
					error : function(e) {
						console.log("ERROR: ", e);
					},
					done : function(e) {
						console.log("DONE");
					}
				});
			}
			function displayFilteredOffers(data) {
				$("#filtered-offers-list").html(data);
			}

			function addToCart(offerId) {
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/addToCart",
					data : JSON.stringify(offerId),
					dataType : 'html',
					timeout : 100000,
					success : function(data) {
						console.log("SUCCESS: ", data);
						updateCart(data);
					},
					error : function(e) {
						console.log("ERROR: ", e);
					},
					done : function(e) {
						console.log("DONE");
					}
				});
			}
			
			function updateCart(data) {
				 $("#offers-with-cart").html(data);
			}

			function removeFromCart(offerId) {
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/removeFromCart",
					data : JSON.stringify(offerId),
					dataType : 'html',
					timeout : 100000,
					success : function(data) {
						console.log("SUCCESS: ", data);
						updateCart(data);
					},
					error : function(e) {
						console.log("ERROR: ", e);
					},
					done : function(e) {
						console.log("DONE");
					}
				});
			}
			
			
			function drag(event) {
				event.dataTransfer.setData("offerId", event.srcElement.id);

			}
			function drop(event) {
				event.preventDefault();
				addToCart(event.dataTransfer.getData("offerId"));
			}
			function dragover(event) {
				event.preventDefault();
				//event.dataTransfer.dropEffect = 'copy';
			}
			var offset = 300,
			$back_to_top = $('.back-to-top');
			$(window).scroll(
					function() {
						($(this).scrollTop() > offset) ? $back_to_top
								.addClass('back-to-top-visible') : $back_to_top
								.removeClass('back-to-top-visible');
					});
			
		
