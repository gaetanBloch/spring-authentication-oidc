package fr.keyconsulting.geode.authentication.shared.pagination.infrastructure.secondary;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;

public final class GeodePages {

  private GeodePages() {}
  //
  //  public static Pageable from(GeodePageable pagination) {
  //    return from(pagination, Sort.unsorted());
  //  }
  //
  //  public static Pageable from(GeodePageable pagination, Sort sort) {
  //    Assert.notNull("pagination", pagination);
  //    Assert.notNull("sort", sort);
  //
  //    return PageRequest.of(pagination.page(), pagination.pageSize(), sort);
  //  }
  //
  //  public static <S, T> GeodePage<T> from(Page<S> springPage, Function<S, T> mapper) {
  //    Assert.notNull("springPage", springPage);
  //    Assert.notNull("mapper", mapper);
  //
  //    return GeodePage
  //      .builder(springPage.getContent().stream().map(mapper).toList())
  //      .currentPage(springPage.getNumber())
  //      .pageSize(springPage.getSize())
  //      .totalElementsCount(springPage.getTotalElements())
  //      .build();
  //  }
}
