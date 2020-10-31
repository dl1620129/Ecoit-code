import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'indexByPageNumber'
})
export class IndexByPageNumberPipe implements PipeTransform {

  transform(i: number, pageNumber?: number): number {
    return (pageNumber - 1) * 10 + i + 1;
  }
}
